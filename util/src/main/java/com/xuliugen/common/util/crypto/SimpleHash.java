package com.xuliugen.common.util.crypto;

import com.xuliugen.common.util.StringUtils;
import com.xuliugen.common.util.codec.Base64;
import com.xuliugen.common.util.codec.ByteSource;
import com.xuliugen.common.util.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * A {@code Hash} implementation that allows any {@link MessageDigest MessageDigest} algorithm name to
 * be used.  This class is a less type-safe variant than the other {@code AbstractHash} subclasses
 * (e.g. {@link }, etc), but it does allow for any algorithm name to be specified in case the other subclass
 * implementations do not represent an algorithm that you may want to use.
 * <p/>
 * As of Shiro 1.1, this class effectively replaces the (now-deprecated) {@link AbstractHash} class.  It subclasses
 * {@code AbstractHash} only to retain backwards-compatibility.
 * @since 1.1
 */
public class SimpleHash extends AbstractHash {

    private static final int DEFAULT_ITERATIONS = 1;

    /**
     * The {@link MessageDigest MessageDigest} algorithm name to use when performing the hash.
     */
    private final String algorithmName;

    /**
     * The hashed data
     */
    private byte[] bytes;

    /**
     * Supplied salt, if any.
     */
    private ByteSource salt;

    /**
     * Number of hash iterations to perform.  Defaults to 1 in the constructor.
     */
    private int iterations;

    /**
     * Cached value of the {@link #toHex() toHex()} call so multiple calls won't incur repeated overhead.
     */
    private transient String hexEncoded = null;

    /**
     * Cached value of the {@link #toBase64() toBase64()} call so multiple calls won't incur repeated overhead.
     */
    private transient String base64Encoded = null;

    /**
     * Creates an new instance with only its {@code algorithmName} set - no hashing is performed.
     * <p/>
     * Because all other constructors in this class hash the {@code source} constructor argument, this
     * constructor is useful in scenarios when you have a byte array that you know is already hashed and
     * just want to set the bytes in their raw form directly on an instance.  After using this constructor,
     * you can then immediately call {@link #setBytes setBytes} to have a fully-initialized instance.
     * <p/>
     * <b>N.B.</b>The algorithm identified by the {@code algorithmName} parameter must be available on the JVM.  If it
     * is not, a {@link RuntimeException} will be thrown when the hash is performed (not at instantiation).
     * @param algorithmName the {@link MessageDigest MessageDigest} algorithm name to use when
     *                      performing the hash.
     * @see RuntimeException
     */
    public SimpleHash(String algorithmName) {
        this.algorithmName = algorithmName;
        this.iterations = DEFAULT_ITERATIONS;
    }

    /**
     * Creates an {@code algorithmName}-specific hash of the specified {@code source} with no {@code salt} using a
     * single hash iteration.
     * <p/>
     * This is a convenience constructor that merely executes <code>this( algorithmName, source, null, 1);</code>.
     * <p/>
     * Please see the
     * {@link #SimpleHash(String algorithmName, Object source, Object salt, int numIterations) SimpleHashHash(algorithmName, Object,Object,int)}
     * constructor for the types of Objects that may be passed into this constructor, as well as how to support further
     * types.
     * @param algorithmName the {@link MessageDigest MessageDigest} algorithm name to use when
     *                      performing the hash.
     * @param source        the object to be hashed.
     */
    public SimpleHash(String algorithmName, Object source) {
        //noinspection NullableProblems
        this(algorithmName, source, null, DEFAULT_ITERATIONS);
    }

    /**
     * Creates an {@code algorithmName}-specific hash of the specified {@code source} using the given {@code salt}
     * using a single hash iteration.
     * <p/>
     * It is a convenience constructor that merely executes <code>this( algorithmName, source, salt, 1);</code>.
     * <p/>
     * Please see the
     * {@link #SimpleHash(String algorithmName, Object source, Object salt, int numIterations) SimpleHashHash(algorithmName, Object,Object,int)}
     * constructor for the types of Objects that may be passed into this constructor, as well as how to support further
     * types.
     * @param algorithmName the {@link MessageDigest MessageDigest} algorithm name to use when
     *                      performing the hash.
     * @param source        the source object to be hashed.
     * @param salt          the salt to use for the hash
     */
    public SimpleHash(String algorithmName, Object source, Object salt) {
        this(algorithmName, source, salt, DEFAULT_ITERATIONS);
    }

    /**
     * Creates an {@code algorithmName}-specific hash of the specified {@code source} using the given
     * {@code salt} a total of {@code hashIterations} times.
     * <p/>
     * By default, this class only supports Object method arguments of
     * type {@code byte[]}, {@code char[]}, {@link String}, {@link java.io.File File},
     * will be thrown.
     * <p/>
     * If you want to be able to hash other object types, or use other salt types, you need to override the
     * {@link #toBytes(Object) toBytes(Object)} method to support those specific types.  Your other option is to
     * convert your arguments to one of the default supported types first before passing them in to this
     * constructor}.
     * @param algorithmName  the {@link MessageDigest MessageDigest} algorithm name to use when
     *                       performing the hash.
     * @param source         the source object to be hashed.
     * @param salt           the salt to use for the hash
     * @param hashIterations the number of times the {@code source} argument hashed for attack resiliency.
     */
    public SimpleHash(String algorithmName, Object source, Object salt, int hashIterations) {
        if (!StringUtils.hasText(algorithmName)) {
            throw new NullPointerException("algorithmName argument cannot be null or empty.");
        }
        this.algorithmName = algorithmName;
        this.iterations = Math.max(DEFAULT_ITERATIONS, hashIterations);
        ByteSource saltBytes = null;
        if (salt != null) {
            saltBytes = convertSaltToBytes(salt);
            this.salt = saltBytes;
        }
        ByteSource sourceBytes = convertSourceToBytes(source);
        hash(sourceBytes, saltBytes, hashIterations);
    }

    /**
     * Acquires the specified {@code source} argument's bytes and returns them in the form of a {@code ByteSource} instance.
     * <p/>
     * This implementation merely delegates to the convenience {@link #toByteSource(Object)} method for generic
     * conversion.  Can be overridden by subclasses for source-specific conversion.
     * @param source the source object to be hashed.
     * @return the source's bytes in the form of a {@code ByteSource} instance.
     * @since 1.2
     */
    protected ByteSource convertSourceToBytes(Object source) {
        return toByteSource(source);
    }

    /**
     * Acquires the specified {@code salt} argument's bytes and returns them in the form of a {@code ByteSource} instance.
     * <p/>
     * This implementation merely delegates to the convenience {@link #toByteSource(Object)} method for generic
     * conversion.  Can be overridden by subclasses for salt-specific conversion.
     * @param salt the salt to be use for the hash.
     * @return the salt's bytes in the form of a {@code ByteSource} instance.
     * @since 1.2
     */
    protected ByteSource convertSaltToBytes(Object salt) {
        return toByteSource(salt);
    }

    /**
     * Converts a given object into a {@code ByteSource} instance.  Assumes the object can be converted to bytes.
     * @param o the Object to convert into a {@code ByteSource} instance.
     * @return the {@code ByteSource} representation of the specified object's bytes.
     * @since 1.2
     */
    protected ByteSource toByteSource(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof ByteSource) {
            return (ByteSource) o;
        }
        byte[] bytes = toBytes(o);
        return ByteSource.Util.bytes(bytes);
    }

    private void hash(ByteSource source, ByteSource salt, int hashIterations) {
        byte[] saltBytes = salt != null ? salt.getBytes() : null;
        byte[] hashedBytes = hash(source.getBytes(), saltBytes, hashIterations);
        setBytes(hashedBytes);
    }

    /**
     * Returns the {@link MessageDigest MessageDigest} algorithm name to use when performing the hash.
     * @return the {@link MessageDigest MessageDigest} algorithm name to use when performing the hash.
     */
    public String getAlgorithmName() {
        return this.algorithmName;
    }

    public ByteSource getSalt() {
        return this.salt;
    }

    public int getIterations() {
        return this.iterations;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    /**
     * Sets the raw bytes stored by this hash instance.
     * <p/>
     * The bytes are kept in raw form - they will not be hashed/changed.  This is primarily a utility method for
     * constructing a Hash instance when the hashed value is already known.
     * @param alreadyHashedBytes the raw already-hashed bytes to store in this instance.
     */
    public void setBytes(byte[] alreadyHashedBytes) {
        this.bytes = alreadyHashedBytes;
        this.hexEncoded = null;
        this.base64Encoded = null;
    }

    /**
     * Sets the iterations used to previously compute AN ALREADY GENERATED HASH.
     * <p/>
     * This is provided <em>ONLY</em> to reconstitute an already-created Hash instance.  It should ONLY ever be
     * invoked when re-constructing a hash instance from an already-hashed value.
     * @param iterations the number of hash iterations used to previously create the hash/digest.
     * @since 1.2
     */
    public void setIterations(int iterations) {
        this.iterations = Math.max(DEFAULT_ITERATIONS, iterations);
    }

    /**
     * Sets the salt used to previously compute AN ALREADY GENERATED HASH.
     * <p/>
     * This is provided <em>ONLY</em> to reconstitute a Hash instance that has already been computed.  It should ONLY
     * ever be invoked when re-constructing a hash instance from an already-hashed value.
     * @param salt the salt used to previously create the hash/digest.
     * @since 1.2
     */
    public void setSalt(ByteSource salt) {
        this.salt = salt;
    }

    /**
     * Returns the JDK MessageDigest instance to use for executing the hash.
     * @param algorithmName the algorithm to use for the hash, provided by subclasses.
     * @return the MessageDigest object for the specified {@code algorithm}.
     * @throws RuntimeException if the specified algorithm name is not available.
     */
    protected MessageDigest getDigest(String algorithmName) throws RuntimeException {
        try {
            return MessageDigest.getInstance(algorithmName);
        } catch (NoSuchAlgorithmException e) {
            String msg = "No native '" + algorithmName + "' MessageDigest instance available on the current JVM.";
            throw new RuntimeException(msg, e);
        }
    }

    /**
     * Hashes the specified byte array without a salt for a single iteration.
     * @param bytes the bytes to hash.
     * @return the hashed bytes.
     * @throws RuntimeException if the configured {@link #getAlgorithmName() algorithmName} is not available.
     */
    protected byte[] hash(byte[] bytes) throws RuntimeException {
        return hash(bytes, null, DEFAULT_ITERATIONS);
    }

    /**
     * Hashes the specified byte array using the given {@code salt} for a single iteration.
     * @param bytes the bytes to hash
     * @param salt  the salt to use for the initial hash
     * @return the hashed bytes
     * @throws RuntimeException if the configured {@link #getAlgorithmName() algorithmName} is not available.
     */
    protected byte[] hash(byte[] bytes, byte[] salt) throws RuntimeException {
        return hash(bytes, salt, DEFAULT_ITERATIONS);
    }

    /**
     * Hashes the specified byte array using the given {@code salt} for the specified number of iterations.
     * @param bytes          the bytes to hash
     * @param salt           the salt to use for the initial hash
     * @param hashIterations the number of times the the {@code bytes} will be hashed (for attack resiliency).
     * @return the hashed bytes.
     * @throws RuntimeException if the {@link #getAlgorithmName() algorithmName} is not available.
     */
    protected byte[] hash(byte[] bytes, byte[] salt, int hashIterations) throws RuntimeException {
        MessageDigest digest = getDigest(getAlgorithmName());
        if (salt != null) {
            digest.reset();
            digest.update(salt);
        }
        byte[] hashed = digest.digest(bytes);
        int iterations = hashIterations - DEFAULT_ITERATIONS; //already hashed once above
        //iterate remaining number:
        for (int i = 0; i < iterations; i++) {
            digest.reset();
            hashed = digest.digest(hashed);
        }
        return hashed;
    }

    public boolean isEmpty() {
        return this.bytes == null || this.bytes.length == 0;
    }

    /**
     * Returns a hex-encoded string of the underlying {@link #getBytes byte array}.
     * <p/>
     * This implementation caches the resulting hex string so multiple calls to this method remain efficient.
     * However, calling {@link #setBytes setBytes} will null the cached value, forcing it to be recalculated the
     * next time this method is called.
     * @return a hex-encoded string of the underlying {@link #getBytes byte array}.
     */
    public String toHex() {
        if (this.hexEncoded == null) {
            this.hexEncoded = Hex.encodeToString(getBytes());
        }
        return this.hexEncoded;
    }

    /**
     * Returns a Base64-encoded string of the underlying {@link #getBytes byte array}.
     * <p/>
     * This implementation caches the resulting Base64 string so multiple calls to this method remain efficient.
     * However, calling {@link #setBytes setBytes} will null the cached value, forcing it to be recalculated the
     * next time this method is called.
     * @return a Base64-encoded string of the underlying {@link #getBytes byte array}.
     */
    public String toBase64() {
        if (this.base64Encoded == null) {
            //cache result in case this method is called multiple times.
            this.base64Encoded = Base64.encodeToString(getBytes());
        }
        return this.base64Encoded;
    }

    /**
     * Simple implementation that merely returns {@link #toHex() toHex()}.
     * @return the {@link #toHex() toHex()} value.
     */
    public String toString() {
        return toHex();
    }

    /**
     * Returns {@code true} if the specified object is a Hash and its {@link #getBytes byte array} is identical to
     * this Hash's byte array, {@code false} otherwise.
     * @param o the object (Hash) to check for equality.
     * @return {@code true} if the specified object is a Hash and its {@link #getBytes byte array} is identical to
     * this Hash's byte array, {@code false} otherwise.
     */
    public boolean equals(Object o) {
        if (o instanceof Hash) {
            Hash other = (Hash) o;
            return Arrays.equals(getBytes(), other.getBytes());
        }
        return false;
    }

    /**
     * Simply returns toHex().hashCode();
     * @return toHex().hashCode()
     */
    public int hashCode() {
        if (this.bytes == null || this.bytes.length == 0) {
            return 0;
        }
        return Arrays.hashCode(this.bytes);
    }
}

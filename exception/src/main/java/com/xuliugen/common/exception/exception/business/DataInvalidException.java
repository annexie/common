package com.xuliugen.common.exception.exception.business;

/*
 * 读入的数据错误，比如读入一个.xls文档，打开却发现不是Excel文档
 */
public class DataInvalidException extends BusinessException {

    private static final long serialVersionUID = -1574579508465141777L;

    public DataInvalidException(String message) {
        super("数据错误: " + message);
    }
}
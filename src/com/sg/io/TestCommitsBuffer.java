package com.sg.io;


/***
 *  
 *   接口                              节点流                                   处理流
 *   InPutStream ------ FileInputStream -----> BufferInputStream
 *   OutPutStream       FileOutputStream       BufferOutPutStream
 *   Reader             FileReader             BufferReader (特有ReaderLine 用来读取一行)
 *   Writer             FileWriter             BufferWriter
 *                          |
 *                          |
 *                          |
 *                         转换流
 *                      作用于节点流之上的
 *                      
 *                      InputStreamReader
 *                      把字符数组转换为字符串
 *                      
 *                      OutPutStreamWriter
 *                      把字符串转换为字符数组
 * 
 *               
 *
 */


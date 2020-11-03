package com.jesuscc.springcloud.entities;
/**
 * @author wangcc
 * @create
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommonResult
 * @Author wangcc
 * @Date 12:53 2020/10/28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private  Integer code;
    private  String message;
    private  T  data;

    private CommonResult(Integer code, String message) {
        this(code, message, null);
    }


}

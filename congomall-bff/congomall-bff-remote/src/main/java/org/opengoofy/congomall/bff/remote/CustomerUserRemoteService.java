/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opengoofy.congomall.bff.remote;

import org.opengoofy.congomall.bff.remote.req.UserLoginCommand;
import org.opengoofy.congomall.bff.remote.resp.UserLoginRespDTO;
import org.opengoofy.congomall.springboot.starter.convention.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * C端用户远程服务调用
 *
 * @author chen.ma
 * @github <a href="https://github.com/opengoofy" />
 * @公众号 马丁玩编程，关注回复：资料，领取后端技术专家成长手册
 */
@FeignClient("customer-user-service")
public interface CustomerUserRemoteService {
    
    /**
     * 用户登录
     */
    @PostMapping("/api/customer-user/login")
    Result<UserLoginRespDTO> login(@RequestBody UserLoginCommand requestParam);
    
    /**
     * 检查用户是否登录
     */
    @GetMapping("/api/customer-user/check-login")
    Result<UserLoginRespDTO> checkLogin(@RequestParam("accessToken") String accessToken);
    
    /**
     * 用户退出登录
     */
    @GetMapping("/api/customer-user/logout")
    Result<Void> logout(@RequestParam("accessToken") String accessToken);
}

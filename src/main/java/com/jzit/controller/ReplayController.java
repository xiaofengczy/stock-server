package com.jzit.controller;

import com.jzit.biz.ReplayBiz;
import com.jzit.utils.Result;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileName: ReplayController Description: 股票复盘
 *
 * @author milk
 * @create 2020/7/1
 */

@RestController
@RequestMapping("/replay")
public class ReplayController {

  @Resource
  private ReplayBiz replayBiz;

  @PostMapping("/uploadFile")
  public Result<Boolean> uploadFile(@RequestParam("file") MultipartFile uploadFile) {
    replayBiz.uploadData(uploadFile);
    return Result.success(true);
  }

}
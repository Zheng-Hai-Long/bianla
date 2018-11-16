package com.bianla.admin.service;

import com.bianla.admin.dto.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ZHL on 2018/11/16.
 */
public interface IUploadService {

    Result uploadNewsCoverImage(MultipartFile image);
}

package com.bianla.admin.service.impl;

import com.bianla.admin.Enum.ResultEnum;
import com.bianla.admin.constant.NewsConstant;
import com.bianla.admin.dto.ImageDTO;
import com.bianla.admin.dto.Result;
import com.bianla.admin.entity.BFile;
import com.bianla.admin.repostory.BFileRepository;
import com.bianla.admin.service.IUploadService;
import com.bianla.admin.utils.DateUtil;
import com.bianla.admin.utils.ImageUtil;
import com.bianla.admin.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by ZHL on 2018/11/16.
 */
@Service
public class UploadServiceImpl implements IUploadService {

    @Autowired
    private BFileRepository bFileRepository;

    @Override
    public Result uploadNewsCoverImage(MultipartFile image) {
        if(image == null){
            return new Result(ResultEnum.EMPTY_FILE);
        }
        String realPath = NewsConstant.NEWS_CONVER_IMAGE_REAL_PATH;
        //按年月日生成文件夹、按时间戳+随机数+原图片名称
        String year = DateUtil.getCurrentYearMonthDay();
        realPath = realPath + "/" + year;
        List<String> imageNameList = ImageUtil.uploadMiddleAndLittler(image, realPath);
        if(imageNameList != null && imageNameList.size() == 3) {//不为空代表上传成功

            BFile bFile = new BFile();
            bFile.setCategory(NewsConstant.NEWS_FILE);
            bFile.setType(NewsConstant.PICTURE_FILE);
            bFile.setUrl(year + imageNameList.get(0));
            bFile.setMiddleUrl(year + imageNameList.get(1));
            bFile.setLittleUrl(year + imageNameList.get(2));
            BFile save = bFileRepository.save(bFile);
            if(save.getId() != null){
                ImageDTO dto = new ImageDTO(bFile.getId(), NewsConstant.NEWS_CONVER_IMAGE_URL + "/" + bFile.getMiddleUrl());
                return new Result(ResultEnum.SUCCESS, dto);
            }
        }
        return ResultUtil.ERROR();
    }
}

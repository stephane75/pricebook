package utils;

import bean.UploadFileBean;
import org.apache.commons.io.FileUtils;
import play.Play;
import play.libs.Codec;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	private final static String FILE_DESTINATION_PATH = "/public/uploads/";
	private final static String FILE_THUMB_DESTINATION_PATH = "thumb__";
	
	private static File init(File file, String randomID){
		if (file == null){
            return null;
        }
        File uploadDir = new File(Play.applicationPath, FILE_DESTINATION_PATH + randomID);
        if (!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        return uploadDir;
	}
	
	public static List<UploadFileBean> saveFile(File file, boolean withThumb) {
        String randomID = Codec.UUID();
        File uploadDir = init(file, randomID);
		File uploadedFile = new File(uploadDir, file.getName());
        try {
            FileUtils.moveFile(file, uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UploadFileBean uploadResult = new UploadFileBean();
        uploadResult.name = file.getName();
        uploadResult.type = "text/plain";
        uploadResult.ref = randomID;
        uploadResult.url = FILE_DESTINATION_PATH + randomID + "/" + file.getName();
        uploadResult.delete_url = null;//"/contests/deleteShot?url=public/uploads/" + randomID + "/" + file.getName();
        uploadResult.size = FileUtils.sizeOf(uploadedFile);
        
        if(withThumb){
	        File thumbnail = new File(uploadDir, FILE_THUMB_DESTINATION_PATH + file.getName());
	        play.libs.Images.resize(uploadedFile, thumbnail, 400, 300, true);
	        uploadResult.thumbnail_url = FILE_DESTINATION_PATH + randomID + "/" + thumbnail.getName();
        }
        ArrayList<UploadFileBean> result = new ArrayList<UploadFileBean>();
        result.add(uploadResult);
        return result;
	}
}

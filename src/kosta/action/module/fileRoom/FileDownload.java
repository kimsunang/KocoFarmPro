package kosta.action.module.fileRoom;
 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.comm.ActionForward;
import kosta.action.comm.IAction;
import kosta.model.module.service.FileService;
import kosta.model.module.vo.Files;
 
 
public class FileDownload implements IAction {
 
    @Override
    public ActionForward execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	ActionForward forward = new ActionForward();
		FileService service = FileService.getInstance();
		
        request.setCharacterEncoding("UTF-8");
 
        int idx = Integer.parseInt(request.getParameter("idx"));
 
        
Files file = new Files();
        // 파일 이름을 받아서
        String file_name = file.getFile_name();

        // 실제 파일이 들어있는 경로에 설정한 
        // upload폴더와 파일 이름을 붙여서
        String uploadFileName = request.getRealPath("/upload") + "/" + file_name;
 
        // 해당 문자에서 파일을 가져온 후
        File downFile = new File(uploadFileName);
 
        // 다운로드
        if (downFile.exists() && downFile.isFile()) {
 
            try {
                // 파일 사이즈 조사하고
                long filesize = downFile.length();

                // content타입과 해더를 셋팅하여 파일을 출력
                response.setContentType("application/x-msdownload");
                response.setContentLength((int) filesize);
                String strClient = request.getHeader("user-agent");
 
                if (strClient.indexOf("MSIE 5.5") != -1) {
                    response.setHeader("Content-Disposition", "filename="
                            + file_name + ";");
                } else {
                    response.setHeader("Content-Disposition",
                            "attachment; filename=" + file_name + ";");
                }
                response.setHeader("Content-Length", String.valueOf(filesize));
                response.setHeader("Content-Transfer-Encoding", "binary;");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "private");
 
                byte b[] = new byte[1024];
 
                BufferedInputStream fin = new BufferedInputStream(
                        new FileInputStream(downFile));
 
                BufferedOutputStream outs = new BufferedOutputStream(
                        response.getOutputStream());
 
                int read = 0;
 
                while ((read = fin.read(b)) != -1) {
                    outs.write(b, 0, read);
                }
                outs.flush();
                outs.close();
                fin.close();
            } catch (Exception e) {
                System.out.println("Download Exception : " + e.getMessage());
            }
        } else {
            System.out.println("Download Error : downFile Error [" + downFile
                    + "]");
        }
        return forward;
        // 여기서 뭘 리턴해야 원래 리스트로 돌아가지?
    }
}

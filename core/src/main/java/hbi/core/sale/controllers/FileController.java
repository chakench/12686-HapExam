package hbi.core.sale.controllers;

import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.sale.dto.OrderInfo;
import hbi.core.sale.service.ICompanysService;
import hbi.core.sale.util.DateUtil;
import hbi.core.sale.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chenhe on 2016/12/17.
 * 导出excel
 */
@RestController
public class FileController extends BaseController{
    @Autowired
    private ICompanysService companysService;

    @RequestMapping(value="/exportExcel")
    public ResponseData exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean f =true;  //是否导出成功
        String fileName="SO_Order_"+ DateUtil.DateToStr(new Date());
        List<OrderInfo> lists= (List<OrderInfo>) request.getSession().getAttribute("excelData");
        //填充订单数据
        List<Map<String,Object>> list=companysService.createExcelRecord(lists);
        String columnNames[]={"销售订单号","公司名称","客户名称","订单日期","订单状态","订单金额"};//列名
        String keys[]    =     {"orderNumber","companyName","customerName","orderDate","orderStatus","totalPrice"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
        } catch (IOException e) {
            f=false;
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            f=false;
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return new ResponseData(true);
    }
}

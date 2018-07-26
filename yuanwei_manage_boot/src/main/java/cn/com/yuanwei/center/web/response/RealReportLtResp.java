package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.RealReport;
import cn.com.yuanwei.center.entity.RealReportVo;
/**
 * 统计局导出表
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:22
 */
public class RealReportLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<RealReportVo> realReportLt;
	private RealReport sum;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<RealReportVo> getRealReportLt() {
		return realReportLt;
	}
	public void setRealReportLt(List<RealReportVo> realReportLt) {
		this.realReportLt = realReportLt;
	}
	public RealReport getSum() {
		return sum;
	}
	public void setSum(RealReport sum) {
		this.sum = sum;
	}
	
}

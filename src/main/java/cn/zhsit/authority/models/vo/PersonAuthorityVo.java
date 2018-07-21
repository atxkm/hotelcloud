package cn.zhsit.authority.models.vo;

import java.util.Date;
import java.util.List;

import cn.zhsit.authority.models.po.PersonRoleRelationAuthority;


public class PersonAuthorityVo {
	private List<PersonRoleRelationAuthority> personRoleRelationAuthoritys;
	
	/**
     * 用户ID
     */
    private String id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 电话
     */
    private String tel;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 头像图片路径
     */
    private String headPic;

    /**
     * 排序号
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

	

	public List<PersonRoleRelationAuthority> getPersonRoleRelationAuthoritys() {
		return personRoleRelationAuthoritys;
	}

	public void setPersonRoleRelationAuthoritys(List<PersonRoleRelationAuthority> personRoleRelationAuthoritys) {
		this.personRoleRelationAuthoritys = personRoleRelationAuthoritys;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
    
    
}

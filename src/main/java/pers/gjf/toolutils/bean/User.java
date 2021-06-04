package pers.gjf.toolutils.bean;

/**
 * <p>File: User.java </p>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Create By: 2021/06/02 09:02 </p>
 * <p>Company: nbnope.cn </p>
 *
 * @author gjf.gu/921208155@qq.com
 * @version 1.0
 */
public class User
{
    private Long id;

    private String name;

    private String birthDay;

    private String remarks;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(String birthDay)
    {
        this.birthDay = birthDay;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
}

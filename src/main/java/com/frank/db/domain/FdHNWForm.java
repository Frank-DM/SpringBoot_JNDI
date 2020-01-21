package com.frank.db.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FdHNWForm {
    private Long S_ROWID;

    private String FOLDER_NM;

    private String FORM_NM;

    private String FUNC_CODE;

    private String SUB_FOLDER_NM;

    private String FORM_ID;
    
    private String PROCESS_NAME;
    
    private String POLICY_NO;

    
    
    
    public String getPROCESS_NAME() {
		return PROCESS_NAME;
	}

	public void setPROCESS_NAME(String pROCESS_NAME) {
		PROCESS_NAME = pROCESS_NAME;
	}

	public String getPOLICY_NO() {
		return POLICY_NO;
	}

	public void setPOLICY_NO(String pOLICY_NO) {
		POLICY_NO = pOLICY_NO;
	}

	public Long getS_ROWID() {
        return S_ROWID;
    }

    public void setS_ROWID(Long S_ROWID) {
        this.S_ROWID = S_ROWID;
    }

    public String getFOLDER_NM() {
        return FOLDER_NM;
    }

    public void setFOLDER_NM(String FOLDER_NM) {
        this.FOLDER_NM = FOLDER_NM == null ? null : FOLDER_NM.trim();
    }

    public String getFORM_NM() {
        return FORM_NM;
    }

    public void setFORM_NM(String FORM_NM) {
        this.FORM_NM = FORM_NM == null ? null : FORM_NM.trim();
    }

    public String getFUNC_CODE() {
        return FUNC_CODE;
    }

    public void setFUNC_CODE(String FUNC_CODE) {
        this.FUNC_CODE = FUNC_CODE == null ? null : FUNC_CODE.trim();
    }

    public String getSUB_FOLDER_NM() {
        return SUB_FOLDER_NM;
    }

    public void setSUB_FOLDER_NM(String SUB_FOLDER_NM) {
        this.SUB_FOLDER_NM = SUB_FOLDER_NM == null ? null : SUB_FOLDER_NM.trim();
    }

    public String getFORM_ID() {
        return FORM_ID;
    }

    public void setFORM_ID(String FORM_ID) {
        this.FORM_ID = FORM_ID == null ? null : FORM_ID.trim();
    }

    @Override
    public String toString() {
        return "FdHNWForm{" +
                "S_ROWID=" + S_ROWID +
                ", FOLDER_NM='" + FOLDER_NM + '\'' +
                ", FORM_NM='" + FORM_NM + '\'' +
                ", FUNC_CODE='" + FUNC_CODE + '\'' +
                ", SUB_FOLDER_NM='" + SUB_FOLDER_NM + '\'' +
                ", FORM_ID='" + FORM_ID + '\'' +
                ", PROCESS_NAME='" + PROCESS_NAME + '\'' +
                ", POLICY_NO='" + POLICY_NO + '\'' +
                '}';
    }
}
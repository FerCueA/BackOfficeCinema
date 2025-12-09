package es.dsw.models;

public class Rol {

    private int idRol; // IDROL_RF
    private String rolCode; // ROLCODE_RF
    private String rolName; // ROLNAME_RF
    private boolean activeRow; // S_ACTIVEROW_RF
    private java.sql.Timestamp insertDate; // S_INSERTDATE_RF
    private java.sql.Timestamp updateDate; // S_UPDATEDATE_RF

    public Rol() {
    }

    public Rol(int idRol, String rolCode, String rolName, boolean activeRow,
            java.sql.Timestamp insertDate, java.sql.Timestamp updateDate) {
        this.idRol = idRol;
        this.rolCode = rolCode;
        this.rolName = rolName;
        this.activeRow = activeRow;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRolCode() {
        return rolCode;
    }

    public void setRolCode(String rolCode) {
        this.rolCode = rolCode;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public boolean isActiveRow() {
        return activeRow;
    }

    public void setActiveRow(boolean activeRow) {
        this.activeRow = activeRow;
    }

    public java.sql.Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(java.sql.Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    public java.sql.Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.sql.Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idRol +
                ", rolCode='" + rolCode + '\'' +
                ", rolName='" + rolName + '\'' +
                ", activeRow=" + activeRow +
                ", insertDate=" + insertDate +
                ", updateDate=" + updateDate +
                '}';
    }
}

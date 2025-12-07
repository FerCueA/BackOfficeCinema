package es.dsw.models;

import java.util.Objects;

public class Usuario {

    private int idUser; // IDUSER_USF
    private String username; // USERNAME_USF
    private String password; // PASSWORD_USF
    private String name; // NAME_USF
    private String firstSurname; // FIRSTSURNAME_USF
    private String secondSurname; // SECOUNDSURNAME_USF
    private String email; // EMAIL_USF
    private boolean activeRow; // S_ACTIVEROW_USF
    private java.sql.Timestamp insertDate; // S_INSERTDATE_USF
    private java.sql.Timestamp updateDate; // S_UPDATEDATE_USF

    public Usuario() {
    }

    public Usuario(int idUser, String username, String password, String name, String firstSurname, String secondSurname,
            String email, boolean activeRow, java.sql.Timestamp insertDate, java.sql.Timestamp updateDate) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.email = email;
        this.activeRow = activeRow;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Usuario idUser(int idUser) {
        setIdUser(idUser);
        return this;
    }

    public Usuario username(String username) {
        setUsername(username);
        return this;
    }

    public Usuario password(String password) {
        setPassword(password);
        return this;
    }

    public Usuario name(String name) {
        setName(name);
        return this;
    }

    public Usuario firstSurname(String firstSurname) {
        setFirstSurname(firstSurname);
        return this;
    }

    public Usuario secondSurname(String secondSurname) {
        setSecondSurname(secondSurname);
        return this;
    }

    public Usuario email(String email) {
        setEmail(email);
        return this;
    }

    public Usuario activeRow(boolean activeRow) {
        setActiveRow(activeRow);
        return this;
    }

    public Usuario insertDate(java.sql.Timestamp insertDate) {
        setInsertDate(insertDate);
        return this;
    }

    public Usuario updateDate(java.sql.Timestamp updateDate) {
        setUpdateDate(updateDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Usuario))
            return false;
        Usuario usuario = (Usuario) o;
        return idUser == usuario.idUser &&
                Objects.equals(username, usuario.username) &&
                Objects.equals(password, usuario.password) &&
                Objects.equals(name, usuario.name) &&
                Objects.equals(firstSurname, usuario.firstSurname) &&
                Objects.equals(secondSurname, usuario.secondSurname) &&
                Objects.equals(email, usuario.email) &&
                activeRow == usuario.activeRow &&
                Objects.equals(insertDate, usuario.insertDate) &&
                Objects.equals(updateDate, usuario.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, username, password, name, firstSurname, secondSurname, email, activeRow, insertDate,
                updateDate);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", email='" + email + '\'' +
                ", activeRow=" + activeRow +
                ", insertDate=" + insertDate +
                ", updateDate=" + updateDate +
                '}';
    }

}

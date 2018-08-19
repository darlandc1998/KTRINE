package Modelos;
import Dao.GenericDaoHibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends GenericDaoHibernate<Usuario>{
    @Id
    private Integer codigo;
    @Column
    private String login;
    @Column
    private String senha;

    public Usuario(){        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", login=" + login + ", senha=" + senha + '}';
    }
    
    
    
}

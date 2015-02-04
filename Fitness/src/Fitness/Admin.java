package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Classe referente ao Administrador.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Admin extends Person implements Serializable {

    /**
     * Construtor Vazio
     */
    public Admin() {
        super();
    }

    /**
     * Construtor parametrizado
     *
     * @param email Email.
     * @param pass Palavra passe.
     * @param name Nome.
     * @param gender Género.
     * @param date Data de Nascimento.
     */
    public Admin(String email, String pass, String name, char gender, GregorianCalendar date) {
        super(email, pass, name, gender, date);
    }

    /**
     * Construtor de cópia.
     *
     * @param admin   instância de Admin.
     */
    public Admin(Admin admin) {
        super(admin.getEmail(), admin.getPassword(), admin.getName(), admin.getGender(), admin.getDate());
    }

    //Equals,toString e Clone
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        } else {
            Admin admin = (Admin) o;
            return (super.equals(admin));
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

        return sb.toString();

    }

    @Override
    public Admin clone() {
        return new Admin(this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

}

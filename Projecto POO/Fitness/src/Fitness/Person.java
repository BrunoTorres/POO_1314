package Fitness;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.io.Serializable;

/**
 * Super classe de user e admin
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public abstract class Person implements Serializable {

    private String email;
    private String password;
    private String name;
    private char gender;
    private GregorianCalendar dateOfBirth;

    /**
     * Construtor vazio
     */
    public Person() {
        this.email = "";
        this.password = "";
        this.name = "";
        this.gender = 'N';
        this.dateOfBirth = new GregorianCalendar();

    }

    /**
     * Construtor parametrizado
     *
     * @param email-Email
     * @param pass-Palavra-passe
     * @param name-Nome
     * @param gender-Género
     * @param date-Data de Nascimento
     */
    public Person(String email, String pass, String name, char gender, GregorianCalendar date) {
        this.email = email;
        this.password = pass;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = (GregorianCalendar) date.clone();
    }

    /**
     * Construtor de cópia
     *
     * @param p-Objecto Person
     */
    public Person(Person p) {
        this.email = p.getEmail();
        this.password = p.getPassword();
        this.name = p.getName();
        this.gender = p.getGender();
        this.dateOfBirth = p.getDate();
    }

    /**
     * Método que devolve o email.
     *
     * @return String email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Método que devolve a palavra-passe.
     *
     * @return String pass.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Método que devolve o nome.
     *
     * @return String nome.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método que devolve o género.
     *
     * @return char género.
     */
    public char getGender() {
        return this.gender;
    }

    /**
     * Método que devolve a data de nascimento.
     *
     * @return GregorianCalendar.
     */
    public GregorianCalendar getDate() {
        return (GregorianCalendar) this.dateOfBirth.clone();
    }

    /**
     * Método para alterar o email.
     *
     * @param email-Novo email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método para alterar a palavra-passe-
     *
     * @param pass-Nova pass.
     */
    public void setPassword(String pass) {
        this.password = pass;
    }

//Equals,toString & Clone
    @Override
    public boolean equals(Object person) {
        if (this == person) {
            return true;
        }
        if ((person == null) || (this.getClass()) != person.getClass()) {
            return false;
        } else {
            Person p = (Person) person;
            return (this.email.equals(p.getEmail())
                    && this.name.equals(p.getName())
                    && this.password.equals(p.getPassword())
                    && (this.gender == (p.getGender()))
                    && this.dateOfBirth.equals(p.getDate()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ");
        sb.append(this.name).append("\n");
        sb.append("Email: ");
        sb.append(this.email).append("\n");
        sb.append("Password: ");
        sb.append(this.password).append("\n");
        sb.append("Gender: ");
        sb.append(this.gender).append("\n");
        sb.append("Date of Birth: ");
        sb.append(this.dateOfBirth.get(Calendar.DAY_OF_MONTH)).append(" / ");
        sb.append(this.dateOfBirth.get(Calendar.MONTH)).append(" / ");
        sb.append(this.dateOfBirth.get(Calendar.YEAR)).append("\n");

        return sb.toString();
    }

    @Override
    public abstract Person clone();


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.gender;
        hash = 59 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }
}

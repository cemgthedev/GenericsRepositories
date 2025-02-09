package app.types;

/*
 * Classe que representa um usuário contendo atributos privados e métodos de acesso getters e setters. 
 */
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private Integer age;

    public User() {}

    public User(String name, String email, String password, String cpf, Integer age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpf='" + cpf + '\'' +
                ", age=" + age +
                '}';
    }
}

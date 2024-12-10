package testes_mobile.models;

public class People {

    private String cpf;
    private String phone;

    // Construtor vazio para permitir campos opcionais
    public People() {}

    // Construtor para casos em que todos os campos são usados
    public People(String cpf, String phone, String email, String password) {
        this.cpf = cpf;
        this.phone = phone;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}

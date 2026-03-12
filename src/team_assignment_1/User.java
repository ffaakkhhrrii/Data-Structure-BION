package team_assignment_1;

public abstract class User {
    
    // Atribut User (Enkapsulasi)
    private String username;
    private String email;
    
    // Constructor
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
    
    // Getter untuk username
    public String getUsername() {
        return username;
    }
    
    // Setter untuk username
    public void setUsername(String username) {
        this.username = username;
    }
    
    // Getter untuk email
    public String getEmail() {
        return email;
    }
    
    // Setter untuk email
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Abstract method untuk menampilkan akses pengguna (Setiap jenis pengguna memiliki akses yang berbeda)
    public abstract void tampilkanAkses();
}


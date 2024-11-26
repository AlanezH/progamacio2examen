package sistemagym;

class Usuario {
    private String nombre;
    private String correo;
    private Membresia membresia;

    public Usuario(String nombre, String correo, Membresia membresia) {
        this.nombre = nombre;
        this.correo = correo;
        this.membresia = membresia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void cancelarMembresia() {
        membresia.desactivar();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Correo: " + correo + ", Membresía: [" + membresia.toString() + "]";
    }
}

package sistemagym;

public class Membresia {
        private String tipo;
        private double precio;
        private boolean activa;

        public Membresia(String tipo, double precio) {
            this.tipo = tipo;
            this.precio = precio;
            this.activa = true;
        }

        public String getTipo() {
            return tipo;
        }

        public double getPrecio() {
            return precio;
        }

        public boolean isActiva() {
            return activa;
        }

        public void desactivar() {
            this.activa = false;
        }

        @Override
        public String toString() {
            return "Tipo: " + tipo + ", Precio: " + precio + ", Activa: " + (activa ? "Sí" : "No");
        }
    }


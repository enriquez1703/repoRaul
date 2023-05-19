
public class Pelicula {
		private String cod_peli;
		private String titulo;
		private String anno_estreno;
		private String nombre_actor;
		private double coste_prod;
		public String getCod_peli() {
			return cod_peli;
		}
		public void setCod_peli(String cod_peli) {
			this.cod_peli = cod_peli;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getAnno_estreno() {
			return anno_estreno;
		}
		public void setAnno_estreno(String anno_estreno) {
			this.anno_estreno = anno_estreno;
		}
		public String getNombre_actor() {
			return nombre_actor;
		}
		public void setNombre_actor(String nombre_actor) {
			this.nombre_actor = nombre_actor;
		}
		public double getCoste_prod() {
			return coste_prod;
		}
		public void setCoste_prod(double coste_prod) {
			this.coste_prod = coste_prod;
		}
		public Pelicula(String cod_peli, String titulo, String anno_estreno, String nombre_actor, double coste_prod) {
			super();
			this.cod_peli = cod_peli;
			this.titulo = titulo;
			this.anno_estreno = anno_estreno;
			this.nombre_actor = nombre_actor;
			this.coste_prod = coste_prod;
		}
		public Pelicula() {
			super();
		}
	}



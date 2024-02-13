
public class HiloA implements Runnable {
	private Integer id;
	private ListaEnlazada l;
	private Integer caso;
	
	public HiloA(Integer id, ListaEnlazada l, Integer caso) {
		this.id=id;
		this.l=l;
		this.caso=caso;
	}
	public void run() {
		
		switch(caso) {
			case 1:
				l.addFina(id,id);
				l.addFina(id+1,id);
				l.addFina(id+2,id);
				l.addFina(id+3,id);
				break;
			case 2:
				l.addOptimista(id,id);
				l.addOptimista(id+1,id);
				l.addOptimista(id+2,id);
				l.addOptimista(id+3,id);
				break;
			case 3:
				l.addSinLocks(id,id);
				l.addSinLocks(id+1,id);
				l.addSinLocks(id+2,id);
				l.addSinLocks(id+3,id);
				break;
		}

	}

}

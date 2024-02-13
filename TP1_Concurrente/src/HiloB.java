
public class HiloB implements Runnable {
	private Integer id;
	private ListaEnlazada l;
	private Integer caso;

	
	public HiloB(Integer id, ListaEnlazada l, Integer caso) {
		this.id=id;
		this.l=l;
		this.caso=caso;

	}
	public void run() {
		
		switch(caso) {
			case 1:
				l.removeFina(id,id);
				l.removeFina(id+1,id);
				l.removeFina(id+2,id);
				l.removeFina(id+3,id);
				break;
			case 2:
				l.removeOptimista(id,id);
				l.removeOptimista(id+1,id);
				l.removeOptimista(id+2,id);
				l.removeOptimista(id+3,id);
				break;
			case 3:
				l.removeSinLocks(id,id);
				l.removeSinLocks(id+1,id);
				l.removeSinLocks(id+2,id);
				l.removeSinLocks(id+3,id);
				break;
		}

	}

}
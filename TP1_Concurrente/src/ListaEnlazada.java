
public class ListaEnlazada{
	    private Nodo head;
	    
	    public ListaEnlazada() {
	    	head = new Nodo (Integer.MIN_VALUE,null);
	    	head.next = new Nodo (Integer.MAX_VALUE,null);
	    } 
	    
	    public void addFina(Object o, Integer id) {
	    	Nodo pred = null, curr = null;
	    	int key= o.hashCode();
	    	try {
	    		System.out.println("Hilo "+id+"A intentando agregar nodo " + o);
	    		pred=head;
	    		pred.lock();
	    		curr=pred.next;
	    		curr.lock();
	    		while(curr.key<key) {
	    			pred.unlock();
	    			pred=curr;
	    			curr=curr.next;
	    			curr.lock();
	    		}
	    		if(key== curr.key) {
	    			System.out.println("Ya existe el nodo "+o);
	    		}
	    		else{
	    			Nodo n= new Nodo(key,o);
	    			pred.next=n;
	    			n.next=curr;
	    			System.out.println("Nodo "+o+" agregado");	
	    		}
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	finally{
	    		pred.unlock();
	    		curr.unlock();
	    	}
	    }
	    public void removeFina(Object o, Integer id) {
	    	Nodo pred = null, curr = null;
	    	int key= o.hashCode();
	    	try {
	    		System.out.println("Hilo "+id+"B intentando eliminar nodo " + o);
	    		pred=head;
	    		pred.lock();
	    		curr=pred.next;
	    		curr.lock();
	    		while(curr.key<key) {
	    			pred.unlock();
	    			pred=curr;
	    			curr=curr.next;
	    			curr.lock();
	    		}
	    		if(key== curr.key) {
	    			pred.next=curr.next;
	    			System.out.println("Nodo "+o+" eliminado");
	    		}
	    		else{
	    			System.out.println("No existe el nodo "+o);	
	    		}
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	finally{
	    		pred.unlock();
	    		curr.unlock();
	    	}
	    }

	    //funcion para verificar los nodos en la lsita enlazada
	    public void imprimir(){
	    	Nodo curr=head;
	    	while(curr!=null) {
	    		System.out.println(curr.item);
	    		curr=curr.next;
	    	}
	    }
	    
	    public void addOptimista(Object o, Integer id) {
	    	int key= o.hashCode();
	    	while(true) {
	    		Nodo pred = head, curr = head.next;
	    		while(curr.key<key) {
	    			pred=curr;
	    			curr=curr.next;
	    		}
    		try {
    			System.out.println("Hilo "+id+"A intentando agregar nodo " + o);
    			pred.lock();
    			curr.lock();
    			if(validate(pred,curr)) {
		    		if(key== curr.key) {
		    			System.out.println("Ya existe el nodo "+o);
		    			break;
		    		}
		    		else{
		    			Nodo n= new Nodo(key,o);
		    			pred.next=n;
		    			n.next=curr;
		    			System.out.println("Nodo "+o+" agregado");
		    			break;
		    		}
    			}
    		}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	finally{
	    		pred.unlock();
	    		curr.unlock();
	    	}
	    	}
	    }
	    public void removeOptimista(Object o, Integer id) {
	    	
	    	int key= o.hashCode();
	    	while(true) {
	    		Nodo pred = head, curr = head.next;
	    		while(curr.key<key) {
	    			pred=curr;
	    			curr=curr.next;
	    		}
    		try {
    			System.out.println("Hilo "+id+"B intentando eliminar nodo " + o);
    			pred.lock();
    			curr.lock();
    			if(validate(pred,curr)) {
		    		if(key== curr.key) {
		    			pred.next=curr.next;
		    			System.out.println("Nodo "+o+" eliminado");
		    			break;
		    		}
		    		else{
		    			System.out.println("No existe el nodo "+o);
		    			break;
		    		}
    			}
    		}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	finally{
	    		pred.unlock();
	    		curr.unlock();
	    	}
	    	}
	    }
	    private boolean validate(Nodo pred, Nodo curr) {
	    	Nodo aux= head;
	    	while(aux.key<=pred.key) {
	    		if(aux==pred)
	    			return pred.next == curr;
	    		aux=aux.next;
	    	}
	    	return false;
	    }
	    
	    public void addSinLocks (Object o, Integer id) {
	    	Nodo pred=head, curr=head.next;
	    	int key=o.hashCode();
	    	System.out.println("Hilo "+id+"A intentando agregar nodo " + o);
	    	while(key>curr.key) {
	    		pred=curr;
	    		curr=curr.next;
	    	}
	    	if(key==curr.key) {
	    		System.out.print("Ya existe el nodo "+o);
	    	}
	    	else {
	    		Nodo n = new Nodo(key, o);
	    		pred.next=n;
	    		n.next=curr;
	    		System.out.println("Nodo "+o+" agregado");
	    	}
	    }
	    public void removeSinLocks(Object o, Integer id) {
	    	System.out.println("Hilo "+id+"B intentando eliminar nodo " + o);
	    	Nodo pred=head, curr=head.next;
	    	int key=o.hashCode();
	    	while(key>curr.key) {
	    		pred=curr;
	    		curr=curr.next;
	    	}
	    	if(key==curr.key) {
	    		pred.next=curr.next;
	    		System.out.print("Nodo "+o+" eliminado");
	    	}
	    	else {
	    		System.out.println("No existe el nodo "+o);
	    	}	    	
	    }
	}


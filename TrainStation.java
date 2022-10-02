public class TrainStation {
    
    private TrainStation head;

    public TrainStation(String name) {
    }






    public void addStation (String name){
        TrainStation station = new TrainStation(name);

        if (this.head == null){
            this.head = station;
        } else {
            TrainStation current = this.head;
            while (current.hasNext()){
                current = current.getNext();
            }
            current.setNext(station);
        }
    }
    
    
    
    
    
    
    private void setNext(TrainStation station) {
    }

    private TrainStation getNext() {
        return null;
    }

    private boolean hasNext() {
        return false;
    }
    
    public static void main(String[] args) {
        
    }
}


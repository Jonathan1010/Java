/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Plantilla;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.DragDropEvent;

/**
 *
 * @author USUARIO
 */
@Named("dndCarsView")
@ViewScoped
public class DNDCarsView implements Serializable {
  
    @Inject
    private CarService service;
 
    private List<Car> cars;
     
    private List<Car> droppedCars;
     
    private Car selectedCar;
     
      
    public void onCarDrop(DragDropEvent<Car> ddEvent) {
        Car car = ddEvent.getData();
  
        droppedCars.add(car);
        cars.remove(car);
    }
     
    public void setService(CarService service) {
        this.service = service;
    }
 
    public List<Car> getCars() {
        return cars;
    }
 
    public List<Car> getDroppedCars() {
        return droppedCars;
    }    
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}
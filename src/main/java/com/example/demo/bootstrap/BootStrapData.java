package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }
    public void addSampleParts(){

        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("fairchild semiconductor");
        o.setName("fairchild");
        o.setInv(55);
        o.setPrice(21.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);

        o= new OutsourcedPart();
        o.setCompanyName("bolt semiconductor");
        o.setName("bolt");
        o.setInv(3);
        o.setPrice(28.0);
        o.setId(101L);
        outsourcedPartRepository.save(o);

        o= new OutsourcedPart();
        o.setCompanyName("chance resistors");
        o.setName("chance");
        o.setInv(4);
        o.setPrice(32.0);
        o.setId(1002);
        outsourcedPartRepository.save(o);

        o= new OutsourcedPart();
        o.setCompanyName("zappy op-amps");
        o.setName("zappy");
        o.setInv(4);
        o.setPrice(50.0);
        o.setId(1003);
        outsourcedPartRepository.save(o);

        o= new OutsourcedPart();
        o.setCompanyName("DaBest inductors");
        o.setName("DaBest");
        o.setInv(44);
        o.setPrice(88.0);
        o.setId(104L);
        outsourcedPartRepository.save(o);

    }
    public void addSampleProducts(){
        Product circuit= new Product("circuit",100.0,15);
        Product opAmp= new Product("opAmp",100.0,15);
        Product resistor= new Product("resistor",100.0,15);
        Product inductor= new Product("inductor",100.0,15);
        Product transistor= new Product("transistor",100.0,15);
        productRepository.save(circuit);
        productRepository.save(opAmp);
        productRepository.save(resistor);
        productRepository.save(inductor);
        productRepository.save(transistor);
    }
    @Override
    public void run(String... args) throws Exception {

        if(productRepository.count() < 1 && outsourcedPartRepository.count() < 1){
            addSampleParts();
            addSampleProducts();
        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }




        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}

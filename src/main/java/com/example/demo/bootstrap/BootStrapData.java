package com.example.demo.bootstrap;

import com.example.demo.domain.GibsonGuitarPart;
import com.example.demo.domain.Guitar;
import com.example.demo.repositories.GibsonPartRepository;
import com.example.demo.repositories.GuitarPartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final GuitarPartRepository guitarPartRepository;
    private final ProductRepository productRepository;

    private final GibsonPartRepository gibsonPartRepository;

    public BootStrapData(GuitarPartRepository guitarPartRepository, ProductRepository productRepository, GibsonPartRepository gibsonPartRepository) {
        this.guitarPartRepository = guitarPartRepository;
        this.productRepository = productRepository;
        this.gibsonPartRepository = gibsonPartRepository;
    }
    public void addSampleParts(){

        GibsonGuitarPart o= new GibsonGuitarPart();
        o.setName("fairchild");
        o.setInv(55);
        o.setPrice(21.0);
        o.setMaxInv(58);
        o.setMinInv(1);
        gibsonPartRepository.save(o);

        o= new GibsonGuitarPart();
        o.setName("bolt");
        o.setInv(3);
        o.setPrice(28.0);
        o.setMaxInv(4);
        o.setMinInv(1);
        gibsonPartRepository.save(o);

        o= new GibsonGuitarPart();
        o.setName("chance");
        o.setInv(5);
        o.setPrice(32.0);
        o.setMaxInv(8);
        o.setMinInv(3);
        gibsonPartRepository.save(o);

        o= new GibsonGuitarPart();
        o.setName("zappy");
        o.setInv(4);
        o.setPrice(50.0);
        o.setMaxInv(7);
        o.setMinInv(2);
        gibsonPartRepository.save(o);

        o= new GibsonGuitarPart();
        o.setName("DaBest");
        o.setInv(44);
        o.setPrice(88.0);
        o.setMaxInv(56);
        o.setMinInv(1);
        gibsonPartRepository.save(o);

    }
    public void addSampleProducts(){
        Guitar stratocaster= new Guitar(1,"stratocaster",100.0,3);
        Guitar telecaster= new Guitar(2,"telecaster",100.0,5);
        Guitar lespaul= new Guitar(3,"lespaul",100.0,55);
        Guitar lespaulstudio= new Guitar(4,"lespaulstudio",100.0,158);
        Guitar transistor= new Guitar(5,"transistor",100.0,185);
        productRepository.save(stratocaster);
        productRepository.save(telecaster);
        productRepository.save(lespaul);
        productRepository.save(lespaulstudio);
        productRepository.save(transistor);
    }
    @Override
    public void run(String... args) throws Exception {

        if(productRepository.count() < 1 && gibsonPartRepository.count() < 1){
            addSampleParts();
            addSampleProducts();
        }

        List<GibsonGuitarPart> outsourcedParts=(List<GibsonGuitarPart>) gibsonPartRepository.findAll();
        for(GibsonGuitarPart part:outsourcedParts){
            System.out.println(part.getName());
        }




        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+ guitarPartRepository.count());
        System.out.println(guitarPartRepository.findAll());

    }
}

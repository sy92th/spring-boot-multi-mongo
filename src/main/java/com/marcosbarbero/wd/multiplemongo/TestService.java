package com.marcosbarbero.wd.multiplemongo;

import com.marcosbarbero.wd.multiplemongo.repository.primary.PrimaryModel;
import com.marcosbarbero.wd.multiplemongo.repository.primary.PrimaryRepository;
import com.marcosbarbero.wd.multiplemongo.repository.secondary.SecondaryModel;
import com.marcosbarbero.wd.multiplemongo.repository.secondary.SecondaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final PrimaryRepository primaryRepository;
    
    private final SecondaryRepository secondaryRepository;
    
    public TestService(PrimaryRepository primaryRepository, SecondaryRepository secondaryRepository) {
        this.primaryRepository = primaryRepository;
        this.secondaryRepository = secondaryRepository;
        System.out.println(("************************************************************"));
        System.out.println(("Start printing mongo objects"));
        System.out.println(("************************************************************"));
        this.primaryRepository.save(new PrimaryModel(null, "Primary database plain object"));
        
        this.secondaryRepository.save(new SecondaryModel(null, "Secondary database plain object"));
        
        List<PrimaryModel> primaries = this.primaryRepository.findAll();
        for (PrimaryModel primary : primaries) {
            System.out.println((primary.toString()));
        }
        
        List<SecondaryModel> secondaries = this.secondaryRepository.findAll();
        
        for (SecondaryModel secondary : secondaries) {
            System.out.println((secondary.toString()));
        }
        
        System.out.println(("************************************************************"));
        System.out.println(("Ended printing mongo objects"));
        System.out.println(("************************************************************"));
    }
}

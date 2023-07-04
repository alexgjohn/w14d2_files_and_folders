package com.codeclan.example.FilesAndFolders.others;

import com.codeclan.example.FilesAndFolders.models.File;
import com.codeclan.example.FilesAndFolders.models.Folder;
import com.codeclan.example.FilesAndFolders.models.Person;
import com.codeclan.example.FilesAndFolders.repositories.FileRepository;
import com.codeclan.example.FilesAndFolders.repositories.FolderRepository;
import com.codeclan.example.FilesAndFolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Person fred = new Person("Fred");
        personRepository.save(fred);

        Person daphne = new Person("Daphne");
        personRepository.save(daphne);

        Person velma = new Person("Velma");
        personRepository.save(velma);

        Person shaggy = new Person("Shaggy");
        personRepository.save(shaggy);


        Folder traps = new Folder("Traps", fred);
        folderRepository.save(traps);

        Folder neckwear = new Folder("Neckwear", fred);
        folderRepository.save(neckwear);

        Folder driving = new Folder("Driving", fred);
        folderRepository.save(driving);


        File beartraps = new File("Bear traps", ".md", 20, traps);
        fileRepository.save(beartraps);

        File nets = new File("Nets", ".md", 18, traps);
        fileRepository.save(nets);
    }
}

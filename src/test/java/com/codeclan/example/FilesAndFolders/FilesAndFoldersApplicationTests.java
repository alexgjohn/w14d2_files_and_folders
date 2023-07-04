package com.codeclan.example.FilesAndFolders;

import com.codeclan.example.FilesAndFolders.models.File;
import com.codeclan.example.FilesAndFolders.models.Folder;
import com.codeclan.example.FilesAndFolders.models.Person;
import com.codeclan.example.FilesAndFolders.repositories.FileRepository;
import com.codeclan.example.FilesAndFolders.repositories.FolderRepository;
import com.codeclan.example.FilesAndFolders.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesAndFoldersApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreatePerson(){
		personRepository.deleteAll();
		Person person = new Person("Peter");
		personRepository.save(person);
	}

	@Test
	public void canCreateFolder(){
		folderRepository.deleteAll();
		personRepository.deleteAll();
		Person person = new Person("Peter");
		personRepository.save(person);
		Folder folder = new Folder("Evil Plans", person);
		folderRepository.save(folder);
	}

	@Test
	public void canCreateFile(){
		folderRepository.deleteAll();
		personRepository.deleteAll();
		Person person = new Person("Peter");
		personRepository.save(person);
		Folder folder = new Folder("Evil Plans", person);
		folderRepository.save(folder);
		File file = new File("killer_bees", ".js", 30, folder);
		fileRepository.save(file);
	}

}

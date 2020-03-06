package edu.leicester.cw3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.leicester.cw3.entity.Lecture;
import edu.leicester.cw3.repository.ModuleRepository;
import edu.leicester.cw3.entity.Module;


@RestController
public class ModuleController {
	
		@Autowired
		ModuleRepository moduleRepository;
		
		@GetMapping("/modules")
		public ResponseEntity<List<Module>> getModules(){
			List<Module> modules = (List<Module>) moduleRepository.findAll();
			
			return new ResponseEntity<List<Module>>(modules,HttpStatus.OK);
		}
		@ResponseStatus(HttpStatus.OK)
		@GetMapping("/modules/{id}")
		Module getModule(@PathVariable long id) {
			Optional<Module> module = moduleRepository.findById(id);
			if (module.isPresent())
				return module.get();
			else
				throw new ResponsesStatusException(HttpStatus.NOT_FOUND, "Module does not exist ");
			
		}
		@GetMapping("/modules/{id}/lectures")
		ResponseEntity<List<Lecture>> getLectureForModule(@PathVariable long id){
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json");
		
		Optional<Module> module = moduleRepository.findById(id);
		if (module.isPresent()) {
			return new ResponseEntity<List<Lecture>>(module.get().get????);
		}else 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, " lecture does not exist bro");
}
		@PostMapping("/modules")
		public ResponseEntity<Module> createModule(@RequestBody Module module){
			Module newModule = moduleRepository.save(module);
			return new ResponseEntity<Module> (newModule, HttpStatus.CREATED);
			}
		@PutMapping(value = "/modules/{id}")
		Module updateModule(@RequestBody Module module, @PathVariable long id) {
			return moduleRepository.findById(id)
					.map(x -> {
						x.setCode(module.getCode());
						x.setTitle(module.getTitle());
						x.setCore(module.getCore());
						x.setSemester(module.getSemester());
						return moduleRepository.save(x);
					})
					.orElseGet(()-> {
						throw new ModuleNotFoundException(id);
						
					});
		}
		@PatchMapping("/modules/{id}")
		Module patch (@RequstBody Map<String, String> update, @PathVariable long id) {
				
			return moduleRepositoryfindById(id)
					.map(x -> {
						String moduleCode = update.get("code");
						if (!StringUtils.isEmpty(moduleCode)) {
							x.setCode(moduleCode);
						}
						String moduleTitle = update.get("title");
						if (!StringUtils.isEmpty(moduleTitle)) {
							x.setCode(moduleTitle);
						}
						String moduleCore = update.get("core");
						if (!StringUtils.isEmpty(moduleCore)) {
							x.setCore(moduleCore);
						}
						String moduleSemester = update.get("semester");
						if (!StringUtils.isEmpty(moduleSemester)) {
							x.setCode(moduleSemester);
						}
						return moduleRepository.save(x);
					})
					.orElseGet(() -> {
						throw new ModuleNotFoundException(id);
					});							
		}
		
		private Optional<Module> moduleRepositoryfindById(long id) {
			// TODO Auto-generated method stub
			return null;
		}
		@DeleteMapping("/modules/{id}")
		void deleteModule(@PathVariable long id) {
			moduleRepository.deleteById(id);
		}
		
}
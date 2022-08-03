package space.eliseev.keycloakadmin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.keycloakadmin.commons.TypeFile;
import space.eliseev.keycloakadmin.entity.Client;
import space.eliseev.keycloakadmin.entity.Realm;
import space.eliseev.keycloakadmin.service.FormBuilderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/formBuilder")
public class FormBuilderController {

    private final FormBuilderService formBuilderService;

    @GetMapping("/downloadAllClient")
    public ResponseEntity<List<Client>> downloadClient() {
        return new ResponseEntity<>(formBuilderService.downloadAllClients(), HttpStatus.OK);
    }

    @GetMapping("/downloadAllRealm")
    public ResponseEntity<List<Realm>> downloadRealm() {
        return new ResponseEntity<>(formBuilderService.downloadAllRealm(), HttpStatus.OK);
    }

    @GetMapping("/downloadAllRole/{fileType}")
    public ResponseEntity<byte[]> downloadRole(@PathVariable TypeFile typeFile) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "roleDtoList." + typeFile);
        return new ResponseEntity<>(formBuilderService.downloadAllRole(typeFile), httpHeaders, HttpStatus.OK);
    }
}

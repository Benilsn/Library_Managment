package library_managment.DTO;

import library_managment.entitys.Client;

public class ClientDTO {

    private Long id;

    private String name;

    private String phone;

    public static ClientDTO converter(Client c){
        ClientDTO clientdto = new ClientDTO();
        clientdto.setId(c.getId());
        clientdto.setName(c.getName());
        clientdto.setPhone(c.getPhone());

        return clientdto;
    }

    public Long getId() {
        return id;
    }

    public ClientDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClientDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ClientDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}

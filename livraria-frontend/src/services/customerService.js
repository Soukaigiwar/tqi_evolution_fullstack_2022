import axios from "axios";

const BASE_URL = "http://localhost:8080/customer";

class CustomerService{

    
    addCustomer(customer){
        return axios.post(BASE_URL, customer);
    }

    getCustomer(){
        return axios.get(BASE_URL);
    }

    getCustomerById(customerId){
        return axios.get(BASE_URL + '/' + customerId);
    }

    deleteCustomer(customerId){
        return axios.delete(BASE_URL + '/' + customerId);
    }
    
}

export default new CustomerService()
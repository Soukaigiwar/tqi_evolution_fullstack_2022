import React, { useState, useEffect } from "react";
import 'bootswatch/dist/flatly/bootstrap.css'
import CustomerService from "../../services/customerService";
import { Link } from "react-router-dom";

const Customer = () => {
    const [customer, setCustomer] = useState([]);

    useEffect(() => {
        getCustomer();
    }, []);

    const getCustomer = () => {
        CustomerService.getCustomer()
            .then((response) => {
                setCustomer(response.data);
                console.log(response.data);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    const deleteCustomer = (customerId) => {
        CustomerService.deleteCustomer(customerId).then((response) => {
            getCustomer();
        }).catch(error => {
            console.log(error);
        })
    }

    return (
        <div className="container">
                <table className="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">CPF</th>
                            <th scope="col">Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        {customer.map((customer) => (
                            <tr className="table-default" key={customer.id}>
                                <td>{customer.name}</td>
                                <td>{customer.cpf}</td>
                                <td>
                                <button type="button" className="btn btn-danger btn-sm" onClick={() => deleteCustomer(customer.id)}>
                                    Excluir
                                </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
                
                <a href="/customer/add-customer">Adicionar Cliente</a>
        </div >
    )
}

export default Customer;
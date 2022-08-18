import React from 'react';
import { Link } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import axios from 'axios';


function EditCustomer() {

    const { register, handleSubmit, formState:{ errors }} = useForm();
    const addPost = data => axios.post("http://localhost:8080/customer", JSON.stringify(data))
        .then(() => {
            console.log("tudo ok.");
        })
        .catch(() => {
            console.log("erro ao enviar dados para api.");
        });

    return (
        <div>
            <h2>Página de editar Clientes</h2>
            <hr />
            <Link to="/">
                <button>Voltar</button>
            </Link>
            <hr />
            <form onSubmit={ handleSubmit(addPost) }>
                <label>Nome</label>
                <input type="text" name="title" { ...register("name") }/>
                <label>CPF</label>
                <input type="text" name="cpf" { ...register("cpf") }/>
                <button type="submit">Salvar</button>
            </form>
        </div>
    )
};

export default EditCustomer;

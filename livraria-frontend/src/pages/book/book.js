import React, { useState, useEffect } from "react";
import 'bootswatch/dist/flatly/bootstrap.css'
import CustomerService from "../../services/customerService";
import { Link } from "react-router-dom";

const Book = () => {

return (
    <div className="container">
        <div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
            <div class="card-header">BookStore</div>
            <div class="card-body">
                <h4 class="card-title">Adicionar Cliente</h4>

            </div>
        </div>
        <form>
            <fieldset>
                <div class="form-group">
                    <label class="col-form-label mt-4" for="inputDefault">Nome</label>
                    <input
                        type="text"
                        placeholder="Digite o nome"
                        name="name"
                        className="form-control"
                    //value={name}
                    //onChange={(e) => setName(e.target.value)}
                    >
                    </input>
                </div>

            

            <div className="form-group mb-2">
                <input
                    type="text"
                    placeholder="CPF"
                    name="cpf"
                    className="form-control"
                //value={cpf}
                //onChange={(e) => setCpf(e.target.value)}
                >
                </input>
            </div>
            {/* <button className="btn bt-primary" onClick={(e) => AddCustomer(e)} >Adicionar</button> */}
            <Link to="/customer" className="btn btn-danger"> Voltar </Link>
        </fieldset>
    </form>
    </div >
)}

export default Book;
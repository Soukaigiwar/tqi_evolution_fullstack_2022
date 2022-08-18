import React from "react";
import { Link } from "react-router-dom";
import '../../styles/default.css';

function Customer() {
    return (
        <div>
            <h2>Página de exibir Clientes</h2>
            <hr />
            <Link to="/">
                <button>Voltar</button>
            </Link>
            <Link to="/edit-customer">
                <button>Editar Clientes</button>
            </Link>
            <hr />
        </div>
    )
};

export default Customer;
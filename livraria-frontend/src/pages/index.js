import React from "react";
import { Link } from "react-router-dom";
import '../styles/default.css';

function Index() {
    return (
        <div>
            <h2>Página Inicial</h2>
            <hr />
            <Link to="/customer">
                <button>Clientes</button>
            </Link>
            <hr />
        </div>
    )
};

export default Index;
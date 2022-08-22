import React from "react"

function Navbar() {

    return(
        <div className="navbar navbar-expand-lg navbar-dark bg-primary">
            <ol className="breadcrumb">
                <li className="breadcrumb-item">
                    <a href="/">
                        Book Store
                    </a>
                </li>
                <li className="breadcrumb-item">
                    <a href="/customer">
                        Clientes
                    </a>
                </li>
                <li className="breadcrumb-item">
                    <a href="/book">
                        Livros
                    </a>
                </li>
                <li className="breadcrumb-item">
                    <a href="/order">
                        Pedidos
                    </a>
                </li>
            </ol>
        </div>
    )
}

export default Navbar
import React from "react";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Index from "./pages/index";
import Customer from "./pages/customer/customer";
import EditCustomer from "./pages/customer/edit-customer";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path='/' element={<Index/>} />
          <Route path='/customer' element={<Customer/>} />
          <Route path='/edit-customer' element={<EditCustomer/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;

import React, { createContext, useCallback, useState } from "react";
import api from "../services/api";

export const BookstoreContext = createContext({
  loading: false,
  customer: {},
  repositories: [],
  starred: [],
});

const BookstoreProvider = ({ children }) => {
  const [bookstoreState, setBookstoreState] = useState({
    hasUser: false,
    loading: false,
    customer: {
      id: undefined,
      name: undefined,
      cpf: undefined,
    },
    repositories: [],
    starred: [],
  });

const getCustomer = (customername) => {
  setBookstoreState((prevState) => ({
    ...prevState,
    loading: !prevState.loading,
  }));
  api
    .get(`customer/${username}`)
    .then(({ data }) => {
      setBookstoreState((prevState) => ({
        ...prevState,
        hasUser: true,
        user: {
          id: data.id,
          name: data.name,
          cpf: data.cpf
        },
      }));
    })
    .finally(() => {
      setBookstoreState((prevState) => ({
        ...prevState,
        loading: !prevState.loading,
      }));
    });
  };
};

export default BookstoreProvider;
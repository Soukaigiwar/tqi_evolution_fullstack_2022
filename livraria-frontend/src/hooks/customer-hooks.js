import { useContext } from "react";
import { CustomerContext } from "../providers/bookstore-providers";

const useCustomer = () => {
  const { customerState, getCustomer } = useContext(
    CustomerContext
  );

  return { customerState, getCustomer };
};

export default useCustomer;

import * as yup from "yup";

export const createOrder = async (form: yup.InferType<typeof schema>): Promise<Order> => {
    const response = await fetch("http://localhost:8080/v1/orders", {
        method: "POST",
        body: JSON.stringify(form),
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }
    });

    if (!response.ok) {
        throw new Error(`Error creating order: ${response.status}`);
    }

    return await response.json();
}

export const schema = yup.object({
    title: yup
        .string()
        .required('Title is required'),
    firstName: yup
        .string()
        .required('First Name is required'),
    lastName: yup
        .string()
        .required('Last Name is required')
});

type Order = yup.InferType<typeof schema> & {
    id: string
}
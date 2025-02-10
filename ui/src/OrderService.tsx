import * as yup from "yup";

export const createOrder = async (form: yup.InferType<typeof schema>): Promise<Order> => {
    // Env specific data ideally should be injected via env vars. This would require SSR/a server component.
    // Any env specific secrets must ONLY be kept on the server and not sent to the SPA.
    // If there's no BFF for the SPA then we'll need to fetch the correct config somehow?
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

// Using yup to describe the schemas and enforce any constraints
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
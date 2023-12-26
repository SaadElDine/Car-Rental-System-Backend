import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function Home() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        loadUsers();
    }, []);

    const loadUsers = async () => {
        try {
            const result = await axios.get("http://localhost:8080/customers");
            setUsers(result.data);
        } catch (error) {
            console.error("Error fetching data: ", error);
            // Handle the error appropriately in your application
        }
    };

    return (
        <div className='container'>
            <div className='py-4'>
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Customer Id</th>
                            <th scope="col">Name</th>
                            <th scope="col">Contact Info</th>
                            <th scope="col">Address</th>
                            <th scope="col">accountInfo</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map((customer, index) => (
                            <tr key={customer.customerId}> {/* Use a unique key */}
                                <th scope="row">{index + 1}</th>
                                <td>{customer.customerId}</td>
                                <td>{customer.name}</td>
                                <td>{customer.contactInfo}</td>
                                <td>{customer.address}</td>
                                <td>{customer.accountInfo}</td>
                                <td>
                                    <button className="btn btn-primary mx-2">View</button>
                                    <button className="btn btn-outline-primary mx-2">Edit</button>
                                    <button className="btn btn-danger mx-2">Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    )
}

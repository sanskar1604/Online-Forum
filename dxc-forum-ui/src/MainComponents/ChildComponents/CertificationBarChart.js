import { useEffect, useState } from "react";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";

import { Bar } from "react-chartjs-2";
ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);
const options = {
  indexAxis: "y",
  elements: {
    bar: {
      borderWidth: 2,
    },
  },
  responsive: true,
  plugins: {
    legend: {
      position: "right",
    },
    title: {
      display: true,
      text: "Certification",
    },
  },
};

const Horizontalchart = () => {
  const [data, setData] = useState({
    labels: [],
    datasets: [
      {
        label: "",
        data: [],
        borderColor: "",
        backgroundColor: "",
      },
      {
        label: "",
        data: [],
        borderColor: "",
        backgroundColor: "",
      },
      {
        label: "",
        data: [],
        borderColor: "",
        backgroundColor: "",
      },
      {
        label: "",
        data: [],
        borderColor: "",
        backgroundColor: "",
      },
      {
        label: "",
        data: [],
        borderColor: "",
        backgroundColor: "",
      },
    ],
  });
  useEffect(() => {
    const fetchData = async () => {
      const url = "http://localhost:9090/total_certificate";
      const url1 = "http://localhost:9090/total_certificate/pass";
      const url2 = "http://localhost:9090/total_certificate/scheduled";
      const url3 = "http://localhost:9090/total_certificate/expired_and_fail";
      const url4 = "http://localhost:9090/total_voucher";
      const labelSet = [];
      const dataSet1 = [];
      const dataSet2 = [];
      const dataSet3 = [];
      const dataSet4 = [];
      const dataSet5 = [];
      await fetch(url)
        .then((data) => {
          console.log("Api data", data);
          const res = data.json();
          return res;
        })
        .then((res) => {
          console.log("ressss", res);
          labelSet.push("Certification");
          dataSet1.push(res);
          console.log(dataSet1);
          setData({
            labels: labelSet,
            datasets: [
              {
                label: "Total DECP",
                data: dataSet1,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
            ],
          });
          //   console.log("arrData", dataSet1, dataSet2);
          console.log("arrData", dataSet1);
        })
        .catch((e) => {
          console.log("error", e);
        });
      await fetch(url1)
        .then((data) => {
          console.log("Api data", data);
          const res = data.json();
          return res;
        })
        .then((res) => {
          console.log("ressss", res);
          dataSet2.push(res);
          console.log(dataSet2);
          setData({
            labels: labelSet,
            datasets: [
              {
                label: "Total DECP",
                data: dataSet1,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
              {
                label: "Pass",
                data: dataSet2,
                borderColor: "rgb(53, 162, 235)",
                backgroundColor: "rgba(53, 162, 235, 0.5)",
              },
            ],
          });
          //   console.log("arrData", dataSet1, dataSet2);
          console.log("arrData", dataSet2);
        })
        .catch((e) => {
          console.log("error", e);
        });

      await fetch(url2)
        .then((data) => {
          console.log("Api data", data);
          const res = data.json();
          return res;
        })
        .then((res) => {
          console.log("ressss", res);
          dataSet3.push(res);
          console.log(dataSet3);
          setData({
            labels: labelSet,
            datasets: [
              {
                label: "Total DECP",
                data: dataSet1,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
              {
                label: "Pass",
                data: dataSet2,
                borderColor: "rgb(53, 162, 235)",
                backgroundColor: "rgba(53, 162, 235, 0.5)",
              },
              {
                label: "Scheduled",
                data: dataSet3,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
            ],
          });
          //   console.log("arrData", dataSet1, dataSet2);
          console.log("arrData", dataSet3);
        })
        .catch((e) => {
          console.log("error", e);
        });

      await fetch(url3)
        .then((data) => {
          console.log("Api data", data);
          const res = data.json();
          return res;
        })
        .then((res) => {
          console.log("ressss", res);
          dataSet4.push(res);
          console.log(dataSet4);
          setData({
            labels: labelSet,
            datasets: [
              {
                label: "Total DECP",
                data: dataSet1,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
              {
                label: "Pass",
                data: dataSet2,
                borderColor: "rgb(53, 162, 235)",
                backgroundColor: "rgba(53, 162, 235, 0.5)",
              },
              {
                label: "Scheduled",
                data: dataSet3,
                borderColor: "rgb(53, 162, 235)",
                backgroundColor: "rgba(53, 162, 235, 0.5)",
              },
              {
                label: "Fail/Expired",
                data: dataSet4,
                borderColor: "rgb(53, 162, 235)",
                backgroundColor: "rgba(53, 162, 235, 0.5)",
              },
            ],
          });
          //   console.log("arrData", dataSet1, dataSet2);
          console.log("arrData", dataSet4);
        })
        .catch((e) => {
          console.log("error", e);
        });

      await fetch(url4)
        .then((data) => {
          console.log("Api data", data);
          const res = data.json();
          return res;
        })
        .then((res) => {
          console.log("ressss", res);
          dataSet5.push(res);
          console.log(dataSet5);
          setData({
            labels: labelSet,
            datasets: [
              {
                label: "Total DECP",
                data: dataSet1,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
              {
                label: "Pass",
                data: dataSet2,
                borderColor: "rgb(53, 162, 235)",
                backgroundColor: "rgba(53, 162, 235, 0.5)",
              },
              {
                label: "Scheduled",
                data: dataSet3,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
              {
                label: "Fail/Expired",
                data: dataSet4,
                borderColor: "rgb(53, 162, 235)",
                backgroundColor: "rgba(53, 162, 235, 0.5)",
              },
              {
                label: "Voucher Issued",
                data: dataSet5,
                borderColor: "rgb(255, 99, 132)",
                backgroundColor: "rgba(255, 99, 132, 0.5)",
              },
            ],
          });
          //   console.log("arrData", dataSet1, dataSet2);
          console.log("arrData", dataSet5);
        })
        .catch((e) => {
          console.log("error", e);
        });
    };

    fetchData();
  }, []);

  return (
    <div style={{ width: "100%", height: "50%" }}>
      {console.log("dataaaaaaaa", data)}
      <Bar data={data} options={options} />
    </div>
  );
};
export default Horizontalchart;
